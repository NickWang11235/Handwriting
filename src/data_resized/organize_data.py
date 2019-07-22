import os
import random
import shutil

path = "D:\\Java Projects\\ML\\src\\data_resized"

os.mkdir("D:\\Java Projects\\ML\\src\\data_resized\\training_set")
os.mkdir("D:\\Java Projects\\ML\\src\\data_resized\\training_set")

for file in os.listdir(path):
	if (file != "testing_set") & (file != "training_set"):
		os.mkdir("D:\\Java Projects\\ML\\src\\data_resized\\testing_set\\" + file)

for folders in os.listdir(path):
	if (folders != "testing_set") & (folders != "training_set"):
		s = set()
		while len(s) != 15:
			s.add(random.randint(1,55))
		for i in s:
			 shutil.move(path + "\\" +folders + "\\" +folders + "_" + str(i) + ".png", "D:\\Java Projects\\ML\\src\\data_resized\\testing_set\\"+ folders + "\\" + folders + "_" + str(i) + ".png")

for folders in os.listdir(path):
	if (folders != "testing_set") & (folders != "training_set"):
		currFolder = path + "\\" + folders
		i=1
		for file in os.listdir(currFolder):
			os.rename(currFolder + "\\" + file, currFolder + "\\" + folders + "_temp" + str(i) + ".png")
			i+=1
		i=1
		for file in os.listdir(currFolder):
			os.rename(currFolder + "\\" + file, currFolder + "\\" + folders + "_" + str(i) + ".png")
			i+=1

path = "D:\\Java Projects\\ML\\src\\data_resized\\testing_set"

for folders in os.listdir(path):
	if (folders != "testing_set") & (folders != "training_set"):
		currFolder = path + "\\" + folders
		i=1
		for file in os.listdir(currFolder):
			os.rename(currFolder + "\\" + file, currFolder + "\\" + folders + "_temp" + str(i) + ".png")
			i+=1
		i=1
		for file in os.listdir(currFolder):
			os.rename(currFolder + "\\" + file, currFolder + "\\" + folders + "_" + str(i) + ".png")
			i+=1

for folders in os.listdir(path):
	if (folders != "testing_set") & (folders != "training_set"):
		shutil.move(path + "\\" + folders, path + "\\" + "training_set" + folders)