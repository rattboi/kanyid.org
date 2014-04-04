#!/usr/bin/env bash
bin/expect-rsync.sh | grep -v spawn | grep -v Password
