define(['backbone', '../model/developer'],

    function(Backbone, Developer) {

        var developerCollection = Backbone.Collection.extend({

            model: Developer,

            url: '/soloregistrame2/developers',

            initialize: function() {

                console.log('initialize developerCollection');
            },

            
        });

        return new developerCollection;
    }
);