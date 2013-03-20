define(['backbone', '../model/repository'],

    function(Backbone, Repository) {

        var repositoryCollection = Backbone.Collection.extend({

            model: Repository,

            url: '/soloregistrame2/repositories',

            initialize: function() {

                console.log('initialize repositoryCollection');
            },

            parse: function(response, xhr) {

                var repositoryArray = response;
                var arrayRepositories = new Array();

                for (i = 0; i < repositoryArray.length; i++) {

                    var repositoryInfo = repositoryArray[i];

                    var repository = new Repository({

                        name: repositoryInfo.name,
                        description: repositoryInfo.description,
                        repositoryUrl: repositoryInfo.repositoryUrl,
                        commitsUrl: repositoryInfo.commitsUrl
                    });

                    arrayRepositories.push(repository);
                }

                return arrayRepositories;
            },
        });

        return new repositoryCollection;
    }
);