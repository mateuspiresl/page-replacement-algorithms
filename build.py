from subprocess import call

try:
	call(["mkdir", "bin/"])
except:
	pass

call(["javac", "-d", "bin/", "src/main/*.java"])

# javac -d bin src/main/*.java