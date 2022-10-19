package api.config;

import services.ErrorService;
import services.ProjectService;
import services.ProjectsService;

import services.ResponseHeadersService;
import services.UserService;
import services.WorkspaceService;

public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }

    },
    RESPONSE_HEADERS {
        @Override
        public Class<?> getEntityService() {
            return ResponseHeadersService.class;
        }
    },
    WORKSPACE {
        @Override
        public Class<?> getEntityService() {
            return WorkspaceService.class;
        }
    },
    ERROR {
        @Override
        public Class<?> getEntityService() {
            return ErrorService.class;
        }
    },
    PROJECTS {
        @Override
        public Class<?> getEntityService() {
            return ProjectsService.class;
        }
    },
    PROJECT {
        @Override
        public Class<?> getEntityService() {
            return ProjectService.class;
        }
    };

    public abstract Class<?> getEntityService();
}
