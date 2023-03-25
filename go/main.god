package main

import (
	"fmt"
	"io"
	"net/http"
	"os"

	"golang.org/x/sys/windows/registry"
)

func createRegistryKey(path string) (registry.Key, func()) {
	var access uint32 = registry.ALL_ACCESS
	key, _, err := registry.CreateKey(registry.LOCAL_MACHINE, path, access)
	if err != nil {
		panic(err)
	}

	return key, func() {
		var err error
		if err = key.Close(); err != nil {
			panic(err)
		}
	}
}

func GetStringValue(registryKey string) (string, bool) {
	var access uint32 = registry.QUERY_VALUE
	regKey, err := registry.OpenKey(registry.LOCAL_MACHINE, registryKey, access)
	if err != nil {
		if err != registry.ErrNotExist {
			panic(err)
		}
		return "", false
	}

	id, _, err := regKey.GetStringValue("ProductID")
	if err != nil {
		panic(err)
		return "", false
	}

	return id, true
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

	os.Chdir("../")
	fmt.Println("Downloading Launcher...")
	downloadFile("LauncherSetup.exe", "https://github.com/Prime-Asylum/Downloads/releases/download/PrimeLauncher/Prime.Launcher.Setup.exe")

}