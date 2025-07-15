#!/bin/bash

# A script to compile the Blockblast project and package it into an executable JAR.

# --- Configuration ---
# Source code directory
SOURCE_DIR="src"
# Directory for compiled .class files and resources
BUILD_DIR="build"
# Directory for the final JAR file
DIST_DIR="dist"
# Name of the final JAR file
JAR_NAME="Blockblast.jar"
# The fully qualified name of your main class
MAIN_CLASS="com.blockblast.Main"
# --- End of Configuration ---

echo "--- Starting Blockblast Build ---"

# 1. Clean up previous builds
echo "1. Cleaning up old build artifacts..."
rm -rf "$BUILD_DIR"
rm -rf "$DIST_DIR"
mkdir -p "$BUILD_DIR/classes"
mkdir -p "$DIST_DIR"

# 2. Compile Java source files
echo "2. Compiling Java source files..."
javac -d "$BUILD_DIR/classes" -sourcepath "$SOURCE_DIR" $(find "$SOURCE_DIR" -name "*.java")

# Check if compilation was successful
if [ $? -ne 0 ]; then
    echo "------------------------------------------------"
    echo "ERROR: Compilation failed. Aborting script."
    echo "------------------------------------------------"
    exit 1
fi

# 3. Copy resource files (like images, textures) to the build directory
# This ensures they are included in the JAR.
echo "3. Copying resource files..."
# The `rsync` command is great for this as it preserves the directory structure.
# It copies everything from src to the classes directory, excluding the .java files.
rsync -a --exclude="*.java" "$SOURCE_DIR/" "$BUILD_DIR/classes/"

# 4. Create a manifest file specifying the Main-Class
echo "4. Creating manifest file..."
echo "Main-Class: $MAIN_CLASS" > "$BUILD_DIR/MANIFEST.MF"

# 5. Create the JAR file
echo "5. Creating the executable JAR file..."
# The jar command arguments:
# c: create a new archive
# v: generate verbose output
# f: specify the archive file name
# m: include manifest information from the given manifest file
# -C <dir> .: changes to the specified directory and includes all files from there.
# This is crucial for correct packaging.
jar cvfm "$DIST_DIR/$JAR_NAME" "$BUILD_DIR/MANIFEST.MF" -C "$BUILD_DIR/classes" .

# 6. Final result check
if [ $? -eq 0 ]; then
  echo "------------------------------------------------"
  echo "SUCCESS: Build completed successfully!"
  echo ""
  echo "The executable JAR file is located at: $DIST_DIR/$JAR_NAME"
  echo ""
  echo "To run your application, use the command:"
  echo "java -jar $DIST_DIR/$JAR_NAME"
  echo "------------------------------------------------"
else
  echo "------------------------------------------------"
  echo "ERROR: Failed to create the JAR file."
  echo "------------------------------------------------"
  exit 1
fi