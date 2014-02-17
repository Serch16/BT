<div class="row-fluid">
    <div class="span6 offset3">   
        <div class="row-fluid">
            <h2>Vista de Producto</h2>
        </div>        
        <table class="table table-striped table-condensed">
            <thead>                
                <tr>    
                    <th>campo</th>
                    <th>valor</th>
                </tr>
            </thead>
            <tbody>
                <tr><td>id</td><td>{{objeto.id}}</td></tr>
                <tr><td>código</td><td>{{objeto.codigo}}</td>
                <tr><td>descripción</td><td>{{objeto.descripcion}}</td>
                <tr><td>precio</td><td>{{objeto.precio}}</td>
                <tr><td>tipo</td><td>{{objeto.id_tipoproducto}}{{id_tipoproducto_desc}}</td>                
            </tbody>          
        </table>    
        <div class="text-right" > 
            <a class="btn" ng-click="back()">Volver</a>
        </div>  
    </div>
</div>
