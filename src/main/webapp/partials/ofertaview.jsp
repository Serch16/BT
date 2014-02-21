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
                <li><a href="#oferta/list/1/10">Ofertas de trabajo</a> <span class="divider">/</span></li>
                <li><a href="#">{{objeto.categoria}}</a> <span class="divider">/</span></li>
                <li class="active">Trabajo de {{objeto.puesto}}</li>
            </ul>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <h3>{{objeto.puesto}}</h3>
            <div class="row">
                <div class="span3">Publicada el:</div>
                <div class="span7">{{objeto.puesto}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Nombre de la empresa:</div>
                <div class="span7">{{objeto.id_empresa}}</div>
                <div class="span2"></div>
            </div>
            <hr/>
            <h4>Ubicaci�n</h4>
            <div class="row">
                <div class="span3">Poblaci�n:</div>
                <div class="span7">{{objeto.puesto}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Provincia:</div>
                <div class="span7">{{objeto.puesto}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Pa�s:</div>
                <div class="span7">{{objeto.puesto}}</div>
                <div class="span2"></div>
            </div>
            <hr/>
            <h4>Descripci�n</h4>
            <div class="row">
                <div class="span3">Puesto vacante:</div>
                <div class="span7">{{objeto.puesto}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Categor�a:</div>
                <div class="span7">{{objeto.categoria}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">N�mero de vacantes:</div>
                <div class="span7">{{objeto.vacantes}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Descripci�n de la oferta:</div>
                <div class="span7">{{objeto.descripcion}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Observaciones:</div>
                <div class="span7">{{objeto.notas}}</div>
                <div class="span2"></div>
            </div>
            <hr/>
            <h4>Requisitos</h4>
            <div class="row">
                <div class="span3">Estudios m�nimos:</div>
                <div class="span7">{{objeto.requisitos}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Experiencia m�nima:</div>
                <div class="span7">{{objeto.funciones}}</div>
                <div class="span2"></div>
            </div>
            <h4>Contrato</h4>
            <div class="row">
                <div class="span3">Tipo de contrato:</div>
                <div class="span7">{{objeto.id_contrato}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Duraci�n:</div>
                <div class="span7">{{objeto.fechaini}}</div>
                <div class="span2"></div>
            </div>
            <div class="row">
                <div class="span3">Jornada laboral:</div>
                <div class="span7">{{objeto.puesto}}</div>
                <div class="span2"></div>
            </div>
        </div>
    </div>
</div>