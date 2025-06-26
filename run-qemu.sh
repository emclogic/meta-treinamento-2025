#!/bin/bash
LOCAL_PATH="$(pwd)"
BUILDDIR="${LOCAL_PATH}/build"
cd layers/poky
. ./oe-init-build-env ${BUILDDIR}
cd ..
runqemu qemuparams="-m 1024 -smp 4 -display sdl,show-cursor=on"
