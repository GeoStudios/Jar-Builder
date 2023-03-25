package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"os/exec"
	"path/filepath"
	"strings"
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
