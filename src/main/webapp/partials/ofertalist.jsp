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
                        <li><a href="#tipoproducto/list/1/10">Empleo público</a></li>
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
                Estás en:
                <li><a href="#oferta/list/1/10">Ofertas de trabajo</a></li>
            </ul>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12 hero-unit">
            <form class="form-inline">
                <input type="text" class="input-small" placeholder="Palabra clave">
                <select>
                    <option>Provincia</option>
                    <option ng-repeat="pro in provincias">{{pro.nombrepro}}</option>
                </select>
                <select>
                    <option>Categoria</option>
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
                <h4>Registros por página</h4> 
                <div id="pagination" ng-bind-html="botoneraNrpp"></div>
                <form class="navbar-form pull-right" action="Controller" method="post" id="nrrpForm" >
                </form> 
            </div> 
        </div>
        <div class="span7">
            <div class="row caja" ng-repeat="ofe in ofertas">
                <div class="row tituOferta">
                    <div class="span12"><h3>{{ofe.puesto}}</h3></div>
                </div>
                <div class="row variosOferta">
                    <div class="span3"><b>{{ofe.categoria}}</b></div>
                    <div class="span3">Ref.: {{ofe.referencia}}</div>
                    <div class="span4">{{ofe.fechaini}}</div>
                    <div class="span2">
                        <div class="btn-group">
                            <a class="btn btn-mini action02" href="#/oferta/view/{{ofe.id}}"><i class="icon-zoom-in"></i></a>
                            <a class="btn btn-mini action03" href="#/oferta/edit/{{ofe.id}}"><i class="icon-pencil"></i></a>
                            <a class="btn btn-mini action04" href="#/oferta/remove/{{ofe.id}}"><i class="icon-remove"></i></a>
                        </div> 
                    </div>
                </div>
                <div class="row descripOferta">
                    <div class="span12">{{ofe.descripcion}}</div>
                </div>
                <div class="row pieOferta">
                    <div class="span4">Vacantes: {{ofe.vacantes}}</div>
                    <div class="span4">{{ofe.id_contrato}}</div>
                    <div class="span4"><b>{{ofe.salario}} euros</b></div>
                </div>

            </div>
        </div>
        <div class="span1">

        </div>
    </div>
    <div id="pagination" ng-bind-html="botoneraPaginas"></div> 
</div>