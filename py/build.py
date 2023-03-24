import os

# def createFile(root, file):
#     if os.path.exists(root):
#         ""
#     else:
#         os.mkdir(root)
#     f = open(root+file, 'x')
#     f.close()
os.chdir(os.path.dirname(__file__))

os.chdir("../")

root = "../src/"
res = []

# Iterate directory
for path in os.listdir(root):
    # check if current path is a file
    if os.path.isfile(os.path.join(root, path)):
        res.append(path)
print(res)

# createFile("../bin/text/", "e.txt")