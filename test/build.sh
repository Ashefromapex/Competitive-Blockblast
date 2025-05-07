#!/bin/bash

# Create bin directory if it doesn't exist
mkdir -p bin

# Compile all Java files
echo "Compiling Java files..."
javac -d bin src/com/blockblast/Main.java src/com/blockblast/gui/gui.java src/com/blockblast/logic/algo.java src/com/blockblast/distributor/distr.java src/com/blockblast/Network/ipconf.java

# Check if compilation was successful
if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

# Create a manifest file for the JAR
echo "Creating manifest file..."
echo "Main-Class: com.blockblast.Main" > manifest.txt

# Create the JAR file
echo "Creating JAR file..."
jar cfm Blockblast.jar manifest.txt -C bin .

# Make the JAR file executable
echo "Making JAR file executable..."
chmod +x Blockblast.jar

echo "Build completed successfully!"
echo "You can run the application with: java -jar Blockblast.jar"