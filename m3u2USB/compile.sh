#!/bin/bash

source /usr/share/commonFunctions.sh

### Main

debug "INFO: Compiling Log.java"
javac -d . Log.java
val="$?"
if [[ "$val" -ne 0 ]]; then
	debug "l2" "ERROR: An error occurred while compiling Log.java!"
else
	debug "l2" "INFO: Log.java compiled successfully!"
fi

debug "INFO: Compiling M3U2USB.java"
javac -d . M3U2USB.java
val="$?"
if [[ "$val" -ne 0 ]]; then
	debug "l2" "ERROR: An error occurred while compiling M3U2USB.java!"
else
	debug "l2" "INFO: M3U2USB.java compiled successfully!"
fi

#EOF
