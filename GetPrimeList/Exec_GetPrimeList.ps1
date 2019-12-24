param($file)

if (-Not $file) {
    Write-Host "Usage) "$myInvocation.MyCommand.name" [output_file]"
    return
}

python .\GetPrimeList.py 100000 | Out-File -Encoding ascii $file
