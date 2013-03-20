define(['jquery', 'underscore', 'backbone', '../model/repository', '../collection/repositoryCollection',
    'text!../templates/repository-template.html'], 

    function($, _, Backbone, Repository, repositoryCollection, RepositoryTemplate) {

        var repositoryView = Backbone.View.extend({

            el: $('#repositories-information'),

            collection: repositoryCollection,

            username: '',

            events: {

            },

            initialize : function(username) {

                this.username = username;

                if (username != null) {

                    this.collection.fetch({

                        async: false,
                        data : $.param({"username" : username}),
                    });
                }
            },

            render: function() {

                console.log('repositoryView.render');

                var data = {
                    
                    /* 
                     * Don't forget!!! collection.models to get the actual Model objects, 
                     * in this case Repository objects.
                     */
                    repos: this.collection.models,
                    username: this.username
                };

                var compiledTemplate = _.template(RepositoryTemplate, data);
                $('#repositories-information').html(compiledTemplate);
            }
        });

        return new repositoryView;
    }
);