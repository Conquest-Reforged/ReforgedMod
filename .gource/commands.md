## Commands

```

gource --output-custom-log ".\logs\$(get-date -f yyyyMMdd)-core.txt" ..
gource --output-custom-log ".\logs\$(get-date -f yyyyMMdd)-content.txt" ..\ReforgedContent
(Get-Content -path ".\logs\$(get-date -f yyyyMMdd)*.txt") -replace "dags-", "dags" | Sort-Object | Set-Content timeline.txt
gource --load-config config.txt

```