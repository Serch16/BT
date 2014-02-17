<div class="row-fluid">
    <div class="span6 offset3">   
        <div class="row-fluid">
            <h2>Vista de Cliente</h2>
        </div>        
        <table class="table table-striped table-condensed">
            <thead>                
                <tr>    
                    <th>campo</th>
                    <th>valor</th>
                </tr>
            </thead>
            <tbody>
                <tr><td>Id</td><td>{{objeto.id}}</td></tr>
                <tr><td>Nombre</td><td>{{objeto.nombre}}</td>
                <tr><td>Primer apellido</td><td>{{objeto.ape1}}</td>
                <tr><td>Segundo apellido</td><td>{{objeto.ape2}}</td>
                <tr><td>Email</td><td>{{objeto.email}}</td>                
            </tbody>
        </table>  
        <div class="text-right" > 
            <a class="btn" ng-click="back()">Volver</a>
        </div>
    </div>
</div>
