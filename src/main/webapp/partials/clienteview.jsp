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
                <tr><td>id</td><td>{{objeto.id}}</td></tr>
                <tr><td>nombre</td><td>{{objeto.nombre}}</td>
                <tr><td>primer apellido</td><td>{{objeto.ape1}}</td>
                <tr><td>segundo apellido</td><td>{{objeto.ape2}}</td>
                <tr><td>email</td><td>{{objeto.email}}</td>                
            </tbody>
        </table>  
        <div class="text-right" > 
            <a class="btn" ng-click="back()">Volver</a>
        </div>
    </div>
</div>
