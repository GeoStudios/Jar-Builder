package main

import (
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"os"
	"os/exec"
	"path/filepath"
	"strings"

	"golang.org/x/sys/windows/registry"
)

func search() (files []string) {
	items, _ := ioutil.ReadDir(".")
	for _, item := range items {
		if item.IsDir() {
			subitems, _ := ioutil.ReadDir(item.Name())
			for _, subitem := range subitems {
				if !subitem.IsDir() {
					// handle file there
					files = append(files, item.Name()+"/"+subitem.Name())
				}
			}
		} else {
			// handle file there
			files = append(files, item.Name())
		}
	}

	return files
}

func GetDesktop() (string, bool) {
	var access uint32 = registry.QUERY_VALUE
	regKey, err := registry.OpenKey(registry.LOCAL_MACHINE, `SOFTWARE\Microsoft\Windows\CurrentVersion\Explorer\FolderDescriptions\{754AC886-DF64-4CBA-86B5-F7FBF4FBCEF5}`, access)
	if err != nil {
		if err != registry.ErrNotExist {
			panic(err)
		}
		return "", false
	}

	id, _, err := regKey.GetStringValue("ParsingName")
	if err != nil {
		panic(err)
		// return "", false
	}

	return id, true
}

func downloadFile(filepath string, url string) (err error) {

	// Create the file
	out, err := os.Create(filepath)
	if err != nil {
		return err
	}
	defer out.Close()

	// Get the data
	resp, err := http.Get(url)
	if err != nil {
		return err
	}
	defer resp.Body.Close()

	// Check server response
	if resp.StatusCode != http.StatusOK {
		return fmt.Errorf("bad status: %s", resp.Status)
	}

	// Writer the body to file
	_, err = io.Copy(out, resp.Body)
	if err != nil {
		return err
	}

	return nil
}

func main() {

	ex, err := os.Executable()
	if err != nil {
		panic(err)
	}
	// file executable
	fmt.Println(ex)

	// the executable directory
	exPath := filepath.Dir(ex)
	fmt.Println(exPath)

	os.Chdir(exPath)

	os.Chdir("../")
	os.Chdir("./src")
	fmt.Println("Downloading Source")
	// exec.Command("git clone https://github.com/Prime-Asylum/Alpha-Craft.git")

	fmt.Println("Indexing Files in Source")

	files := search()

	for _, v := range files {

		if strings.Contains(v, ".java") {
			d, _ := os.Getwd()
			fmt.Println(d + `\` + strings.ReplaceAll(v, "/", `\`))
			e := exec.Command("javac", d+`\`+strings.ReplaceAll(v, "/", `\`))
			fmt.Println(e.Output())
			os.Remove(d + `\` + strings.ReplaceAll(v, "/", `\`))
		}

	}

	// os.Chdir("./src")

}
