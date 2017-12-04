#!/bin/zsh

alias g=git

function die() {
    echo $@
    exit
}

echo "---"
echo "$1: Installing sbt-pit..."
if [[ ! -d sbt-pit ]]; then
    git clone https://github.com/alexec/sbt-pit || die "couldn't clone sbt-pit"
fi

cd sbt-pit
sbt publishLocal || die "couldn't install sbt-pit"
cd ..

echo "---"
echo "$1: Installing pitest-scalatest-plugin..."
if [[ ! -d pitest-scalatest-plugin ]]; then
    g clone https://github.com/alexec/pitest-scalatest-plugin.git || die "couldn't clone pitest-scalatest-plugin"
fi
cd pitest-scalatest-plugin

mkdir project
cp ../patch/build.properties project/build.properties || die "couldn't patch pitest-scalatest-plugin"
rm -fr target project/target
sbt publishLocal || die "couldn't install pitest-scalatest-plugin"

echo "$1: installed all necessary plugins"

