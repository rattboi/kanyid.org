#!/usr/bin/env bash

if [ "${TRAVIS_BRANCH}" != "master" ];then
echo "Not master, not publishing";
    exit 0;
fi

bin/expect-rsync.sh | grep -v spawn | grep -v RSA | grep -v Password
