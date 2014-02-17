'use strict';

/* Controllers */

var moduloProducto = angular.module('myApp.productoControllers', []);



moduloProducto.controller('controlProductoList', function($scope, $routeParams, serverService) {
    $scope.clase = "producto";
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

    $scope.productos = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
        $scope.productos = datos3['list'];

    });

    $scope.fieldNames = serverService.getFieldNames($scope.clase).then(function(datos6) {
        $scope.fieldNames = datos6['data'];
        $scope.selectedFilterFieldName = null;
    });


    $scope.$watch('numPagina', function() {
        $scope.$broadcast('myApp.construirPagina');
    }, true)

    $scope.$on('myApp.construirPagina', function() {

        $scope.clientes = serverService.getPage($scope.clase, $scope.numPagina, null, null, $scope.nrpp, null, null, null, null, null, null).then(function(datos3) {
            $scope.clientes = datos3['list'];

        });

    })


});


moduloProducto.controller('controlProductoView', function($scope, $routeParams, serverService) {
    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;
    $scope.objeto = serverService.get('producto', $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
        $scope.id_tipoproducto_desc = serverService.get('tipoproducto', $scope.objeto.id_tipoproducto).then(function(datos5) {
            $scope.id_tipoproducto_desc = " (" + datos5.descripcion + ")";
        })
    });
});


moduloProducto.controller('controlProductoEdit', function($scope, $routeParams, $location, serverService, sharedSpaceService) {
    sharedSpaceService.setReturnLink('/producto/edit');

    $scope.back = function() {
        window.history.back();
    };
    $scope.id = $routeParams.id;

    $scope.objeto = serverService.get('producto', $scope.id).then(function(datos4) {
        $scope.objeto = datos4;
        if (sharedSpaceService.getIsDirty().value == true) {
            sharedSpaceService.setIsDirty({value: false});
            var o = sharedSpaceService.getObject();
            $scope.objeto = o;
        }
        $scope.id_tipoproducto_desc = serverService.get('tipoproducto', $scope.objeto.id_tipoproducto).then(function(datos5) {
            $scope.id_tipoproducto_desc = datos5.descripcion;
        })
    });

    $scope.go = function(hash) {
        var boomerang = {returnLink: '/producto/edit/' + $scope.id};
        sharedSpaceService.setObject($scope.objeto);
        sharedSpaceService.setReturnLink(boomerang);
        sharedSpaceService.setIsDirty({value: false});
        var sitio = '/' + hash + '/selection/1/10';
        $location.path(sitio);
    };

});
