#!/usr/bin/env bash
bin/expect-rsync.sh | grep -v expect | grep -v Password
