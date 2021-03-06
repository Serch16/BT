<div class="container back">
    <div class="masthead">
        <div class="row">
            <div class="muted span4"><img id="logoinstituto" src="img/logo.png"></div>
            <div class="span4 cabeinfo"></div>
            <div class="span4 cabeinfo"><button>Soy una (empresa)</button></div>
        </div>
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li><a href="#producto/list/1/10"><span><i class="icon-home"></i></span> Inicio</a></li>
                        <li class="active"><a href="#oferta/list/1/10">Ofertas de trabajo</a></li>
                        <li><a href="#tipoproducto/list/1/10">Empleo p�blico</a></li>
                    </ul>
                </div>
            </div>
        </div><!-- /.navbar -->
    </div>
</div>
<div class="container back">
    <div class="row-fluid">
        <div class="span12">
            <ul class="breadcrumb">
                Est�s en:
                <li><a href="#provincia/list/1/10">Provincias</a></li>
            </ul>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12 hero-unit">
            <form class="form-inline">
                <input type="text" class="input-small" placeholder="Palabra clave">
                <select>
                    <option>Provincia</option>
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                </select>
                <select>
                    <option>Categoria</option>
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                </select>
                <button type="submit" class="btn">Buscar ofertas</button>
            </form>
            <span ng-bind-html="numOfertas"></span><span> <strong>OFERTAS</strong> de empleo en <strong>objeto.provincia</strong></span>
        </div>
        <div class="span12">
        </div>
    </div>
    <div class="row-fluid">
        <div class="span4">
            <div class="text">
                <h4>Filtro</h4>
                <form class="navbar-form pull" action="Controller" method="post" id="empresaForm">
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
                            <input type="submit" class="btn" id="btnFiltrar" name="btnFiltrar" value="Filtrar por" />
                        </span>
                    </fieldset>
                </form>
            </div>
            <br/>
            <div class="text">
                <h4>Registros por p�gina</h4> 
                <div id="pagination" ng-bind-html="botoneraNrpp"></div>
                <form class="navbar-form pull-right" action="Controller" method="post" id="nrrpForm" >
                </form> 
            </div> 
        </div>
        <div class="span7">
            <div class="row caja" ng-repeat="pro in provincias">
                <div class="row variosOferta">
                    <div class="span3">Identificador: <b>{{pro.id}}</b></div>
                    <div class="span3">Provincia: {{pro.nombrepro}}</div>
                    <div class="span4"></div>
                    <div class="span2"></div>
                </div>
            </div>
        </div>
        <div class="span1">

        </div>
    </div>
    <div id="pagination" ng-bind-html="botoneraPaginas"></div> 
</div>