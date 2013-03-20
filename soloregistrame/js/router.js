define(['jquery', 'underscore', 'backbone', 'modules/home/homeView', 
    'modules/developer/views/registerDeveloperView', 
    'modules/developer/views/loginDeveloperView', 'modules/developer/views/developerProfileView',
    'modules/error/errorView'],

    function($, _, Backbone, homeView, registerDeveloperView, loginDeveloperView, developerProfileView, errorView) {

        var AppRouter = Backbone.Router.extend({


            // Define URL routes

            routes: {

                // Static routes
                
                '': 'goHome',
                'register': 'registerDeveloper', // #/register
                'login': 'authenticateDeveloper', // #/login

                // Dynamic routes

                'developers/:username': 'getSingleDeveloper',

                // Error

                'error': 'showErrorPage', // #/error

                // Otherwise: a route that doesn't match with any of the specified routes.
                '*otherwise': 'unknownRoute'
            },

            goHome: function() {

                console.log('router: goHome');
                homeView.render();
            },

            registerDeveloper: function() {

                console.log('router: registerDeveloper');
                registerDeveloperView.render();
            },

            authenticateDeveloper: function() {

                console.log('router: authenticateDeveloper');
                loginDeveloperView.render();
            },

            getSingleDeveloper: function(username) {

                console.log('router: getSingleDeveloper');
                developerProfileView.initialize(username);
                developerProfileView.render();
            },

            showErrorPage: function() {

                console.log('router: showErrorPage');
                errorView.render();
            },

            unknownRoute: function() {

                console.log('router: unknownRoute');
                errorView.render();
            }
        });

        var initialize = function() {
            var app_router = new AppRouter;
            Backbone.history.start();
        };

        return {
            initialize : initialize
        };
    }
);