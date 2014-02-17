<div class="row-fluid">
    <div class="span6 offset3">   
        <div class="row-fluid">
            <h2>Vista de Tipo de producto</h2>
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
                <tr><td>descripción</td><td>{{objeto.descripcion}}</td>             
            </tbody>
        </table> 
        <div class="text-right" > 
            <a class="btn" ng-click="back()">Volver</a>
        </div>
    </div>
</div>
