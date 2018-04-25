#!/bin/bash

source /usr/share/commonFunctions.sh

### Functions

function compile() {
    # Make sure $1 is present
    if [[ -z $1 ]]; then
        debug "l2" "ERROR: No argument given to compile()!"
        return 1
    fi
    
    # Verify java file, and delete existing .class file
    if [[ "$1" != *.java ]]; then
        debug "l2" "ERROR: $1 is not a .java file! Skipping compilation..."
        return 1
    fi
    if [[ -e "$(echo "$1" | cut -d'.' -f1)".class ]]; then
        debug "WARN: Deleting previous .class file for $1"
        rm "$(echo "$1" | cut -d'.' -f1)".class
    fi
    
    # Compile
    debug "INFO: Attempting to compile $1"
    javac "$1"
    return "$?"
}

function report() {
    if [[ -z $1 || "$1" -ne "$1" ]]; then
        debug "l2" "ERROR: No number given with report()!"
        return 1
    fi
    
    if [[ "$1" -ne 0 ]]; then
        debug "l2" "ERROR: Program compilation unsuccessful! Return code: $1"
    else
        debug "INFO: Program compiled successfully!"
    fi
    
    return "$1"
}

### Main

for file in *.java; do
    compile "$file"
    report "$?"
done

#EOF
