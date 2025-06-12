$rutaBase = "C:\2025_VSCode\05_Viernes_13\agrupado\"
$proyectos = @('demo-rest-ventas','demo-rest-productos','demo-rest-clientes',
'demo-rest-busquedas','api-gateway','discover')
$puertos = @(50003,50002,50001,50004,50000,8099)

for ($i = 0; $i -lt $proyectos.Length; $i++) {
    $ruta = $rutaBase+$proyectos[$i]
    Set-Location -Path $ruta
    mvn clean install
    docker build -t $proyectos[$i] .
}
<# 
for ($i = 0; $i -lt $proyectos.Length; $i++) {
    $ruta = $rutaBase+$proyectos[$i]
    Set-Location -Path $ruta
    docker run $proyectos[$i] --net=host -p:$puertos[$i]:$puertos[$i] -d $proyectos[$i] -n $proyectos[$i]
}
 #>


