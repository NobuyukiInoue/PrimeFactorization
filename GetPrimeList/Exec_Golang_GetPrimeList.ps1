param($max, $file)

if ((-Not $max) -Or (-Not $file)) {
    Write-Host "Usage) "$myInvocation.MyCommand.name" <max> <output_file>"
    return
}

go run .\GetPrimeList.go $max | Out-File -Encoding ascii $file
