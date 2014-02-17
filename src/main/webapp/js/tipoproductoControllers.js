'use strict';

/* Controllers */

var moduloTipoproducto = angular.module('myApp.tipoproductoControllers', []);


//------------------------------------------------------------------------------
moduloTipoproducto.controller('controlTipoproductoList', function($scope, $routeParams, serverService) {
    $scope.clase = "tipoproducto";
    $scope.accion = "list";

    $scope.numPagina = $routeParams.numpage;
    $scope.nrpp = $routeParams.numrpp;
    $scope.botoneraNrpp = serverService.getNrppBar($scope.clase, $scope.accion, $scope.numPagina, $scope.nrpp);

    $scope.pages = serverService.getPages($scope.clase, $scope.nrpp, null, null, null, null, null, null).then(function(datos5) {
        $scope.pages = datos5['data'];
        if (parseInt($scope.numPagina) > parseInt($scope.pages))
            $scope.numPagina = $scope.pages;
    });

    $scope.$watch('pages', function() {
        $scope.$broadcast('myApp.construirBotoneraPaginas');
    }, true)

    $scope.$on('myApp.construirBotoneraPaginas', function() {
        $scope.botoneraPaginas = serverService.getPaginationBar($scope.clase, $scope.accion, $scope.numPagina, $scope.pages, 2, $scope.nrpp);
    })

    $scope.prettyFieldNames = serverService.getPrettyFieldNames($scope.clase).then(function(datos4) {
        datos4['data'].push('acciones');
        $scope.prettyFieldNames = datos4['data'];
    });

    $scope.objetos = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
        $scope.objetos = datos3['list'];

    });

    $scope.fieldNames = serverService.getFieldNames($scope.clase).then(function(datos6) {
        $scope.fieldNames = datos6['data'];
        $scope.selectedFilterFieldName = null;
    });


    $scope.$watch('numPagina', function() {
        $scope.$broadcast('myApp.construirPagina');
    }, true)

    $scope.$on('myApp.construirPagina', function() {

        $scope.objetos = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
            $scope.objetos = datos3['list'];

        });

    })


});



//------------------------------------------------------------------------------
moduloTipoproducto.controller('controlTipoproductoEdit', function($scope, $routeParams, serverService) {
    $scope.clase = "tipoproducto";

    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get($scope.clase, $scope.id).then(function(datos4) {
        $scope.objeto = datos4;

    });
});



moduloTipoproducto.controller('controlTipoproductoSelection', function($scope, $routeParams, $location, serverService, sharedSpaceService) {

    $scope.clase = "tipoproducto";
    $scope.accion = "selection";

    $scope.go = function(num) {
        $scope.compartida = sharedSpaceService.getObject();
        $scope.compartida.id_tipoproducto = num;
        sharedSpaceService.setObject($scope.compartida);
        sharedSpaceService.setIsDirty({value: true});
        var boomerang = sharedSpaceService.getReturnLink();
        $location.path(boomerang.returnLink);
    };

    $scope.back = function() {
        window.history.back();
    };

    $scope.numPagina = $routeParams.numpage;
    $scope.nrpp = $routeParams.numrpp;
    $scope.botoneraNrpp = serverService.getNrppBar($scope.clase, $scope.accion, $scope.numPagina, $scope.nrpp);

    $scope.pages = serverService.getPages($scope.clase, $scope.nrpp, null, null, null, null, null, null).then(function(datos5) {
        $scope.pages = datos5['data'];
        if (parseInt($scope.numPagina) > parseInt($scope.pages))
            $scope.numPagina = $scope.pages;
    });

    $scope.$watch('pages', function() {
        $scope.$broadcast('myApp.construirBotoneraPaginas');
    }, true)

    $scope.$on('myApp.construirBotoneraPaginas', function() {
        $scope.botoneraPaginas = serverService.getPaginationBar($scope.clase, $scope.accion, $scope.numPagina, $scope.pages, 2, $scope.nrpp);
    })

    $scope.prettyFieldNames = serverService.getPrettyFieldNames($scope.clase).then(function(datos4) {
        datos4['data'].push('acciones');
        $scope.prettyFieldNames = datos4['data'];
    });

    $scope.objetos = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
        $scope.objetos = datos3['list'];

    });

    $scope.fieldNames = serverService.getFieldNames($scope.clase).then(function(datos6) {
        $scope.fieldNames = datos6['data'];
        $scope.selectedFilterFieldName = null;
    });


    $scope.$watch('numPagina', function() {
        $scope.$broadcast('myApp.construirPagina');
    }, true)


    $scope.$on('myApp.construirPagina', function() {
        $scope.objetos = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
            $scope.objetos = datos3['list'];
        });
    })

});

//------------------------------------------------------------------------------
moduloTipoproducto.controller('controlTipoproductoView', function($scope, $routeParams, serverService) {
    $scope.clase = "tipoproducto";
    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get($scope.clase, $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
    });
});