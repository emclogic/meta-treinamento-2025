#!/bin/bash
LOCAL_PATH="$(pwd)"
BUILDDIR="${LOCAL_PATH}/build"
cd layers/poky
. ./oe-init-build-env ${BUILDDIR}
cd ..
bitbake  core-image-grafico -c populate_sdk
