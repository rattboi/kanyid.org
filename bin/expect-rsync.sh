#!/usr/bin/expect -f
set timeout -1
spawn rsync -e "ssh -o StrictHostKeyChecking=no" -arvuz public_html $env(DEPLOY_USERNAME)@$env(DEPLOY_HOST):$env(DEPLOY_REMOTEDIR)
expect -exact "Password: "
send -- "$env(DEPLOY_PASSWORD)\r"
expect {\$\s*} { interact }
