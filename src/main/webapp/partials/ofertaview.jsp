<div class="row-fluid">
    <div class="span6 offset3">   
        <div class="row-fluid">
            <h2>Vista de Oferta</h2>
        </div>        
        <table class="table table-striped table-condensed">
            <thead>                
                <tr>    
                    <th>campo</th>
                    <th>valor</th>
                </tr>
            </thead>
            <tbody>
                <tr><td>Id.</td><td>{{objeto.id}}</td></tr>
                <tr><td>Referencia</td><td>{{objeto.referencia}}</td>
                <tr><td>Categoria</td><td>{{objeto.categoria}}</td>
                <tr><td>Descripción</td><td>{{objeto.descripcion}}</td>
                <tr><td>Requisitos</td><td>{{objeto.requisitos}}</td>                
            </tbody>
        </table>  
        <div class="text-right" > 
            <a class="btn" ng-click="back()">Volver</a>
        </div>
    </div>
</div>
