// Require.js allows us to configure shortcut alias
// Their usage will become more apparent futher along in the tutorial.
require.config({

	paths : {

		jquery : 'lib/jquery',
		underscore : 'lib/underscore',
		backbone : 'lib/backbone',
		text : 'lib/text'
	},

	shim : {

		'underscore': {
            exports: '_'
        },

		'backbone' : {
			//These script dependencies should be loaded before loading backbone.js
			deps : ['jquery', 'underscore'],
			//Once loaded, use the global 'Backbone' as the module value.
			exports : 'Backbone'
		}
	}
});

require([

// Load our app module and pass it to our definition function
'app'

// Some plugins have to be loaded in order due to their non AMD compliance
// Because these scripts are not "modules" they do not pass any values to the definition function below
], function(App) {
		// The "app" dependency is passed in as "App"
		// Again, the other dependencies passed in are not "AMD" therefore don't pass a parameter to this function
		App.initialize();
	}
);