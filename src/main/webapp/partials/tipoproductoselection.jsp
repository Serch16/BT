

<div class="row-fluid">
    <div class="span7">       
        <h2>Tipos de Producto</h2>
        <div id="order"></div>
        <div id="filter"></div>  
        <div id="registers">Mostrando {{objetos.length}} registros ({{nrpp}} por p�gina)</div>
        <div id="pagination" ng-bind-html="botoneraPaginas"></div>
        
    </div>
    <div class="span5">
        <div class="text-right">
            <legend>Filtro</legend> 
            <form class="navbar-form pull-right" action="Controller" method="post" id="empresaForm">
                <fieldset>                                                                     
                    <span>                                                                     
                        <select ng-model="selectedFilterFieldName"  ng-options="item for item in fieldNames"  id="filtro" name="filtro" style="width: 100px">                                                       
                        </select>
                    </span>
                    <span>
                        <select id="selectFilteroperator" name="filteroperator" width="80" style="width: 100px">
                            <option>like</option>
                            <option>notlike</option>
                            <option>equals</option>
                            <option>notequalto</option>
                            <option>less</option>
                            <option>lessorequal</option>
                            <option>greater</option>
                            <option>greaterorequal</option> 
                        </select>
                        <input id="inputFiltervalue" name="filtervalue" type="text" size="20" maxlength="50" value=""  width="100" style="width: 90px"/>
                    </span>
                    <span>
                        <input type="submit" class="btn" id="btnFiltrar" name="btnFiltrar" value="Filtrar ooo" />
                    </span>
                </fieldset>
            </form>
        </div>
        <div class="text-right">
            <legend>Registros por p�gina</legend> 
            <div id="pagination" ng-bind-html="botoneraNrpp"></div>
            <!--
            <form class="navbar-form pull-right" action="Controller" method="post" id="nrrpForm" >
                <fieldset>                                               
                    <span>
                        <select ng-model="nrpp"  ng-options="item.id as item.desc for item in nrpps"  id="nrpp" name="nrpp" style="width: 200px">                                                
                        </select>  
                    </span>  
           
                </fieldset>
            </form> 
            -->
        </div> 
        <button class="btn" id="crear">Crear Producto</button>
    </div>
</div>
<br>
<div id="datos">
    <table class="table table-striped table-condensed">
        <thead>                
            <tr>                
                <th ng-repeat="name in prettyFieldNames" style="min-width: 80px;">{{name}}</th>                   
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="obj in objetos">
                <td>{{obj.id}}</td>
                <td>{{obj.descripcion}}</td>                
                <td>
                    <div class="btn-toolbar">
                        <div class="btn-group">
                            <a class="btn btn-mini action02" ng-click="go(obj.id)"><i class="icon-ok"></i></a>
                        </div> 
                    </div>

                </td>
            </tr>
        </tbody>
    </table>   
       
</div>


