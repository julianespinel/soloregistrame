define(['backbone'],

    function(Backbone) {

        var repository = Backbone.Model.extend({

            urlRoot: '/soloregistrame2/repositories',

            defaults: {

                id: null,
                name: '',
                description: '',
                repositoryUrl: '',
                commitsUrl: ''
            },

            parse : function(response, xhr) {

                this.set({

                    id: response.id,
                    name: response.name,
                    description: response.description,
                    repositoryUrl: response.repositoryUrl,
                    commitsUrl: response.commitsUrl
                });
            },
        });

        return repository;
    }
);