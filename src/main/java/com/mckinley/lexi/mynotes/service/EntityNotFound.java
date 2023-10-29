package com.mckinley.lexi.mynotes.service;

class EntityNotFound extends RuntimeException {

    EntityNotFound(Integer id, String type) {
      super("Could not find "+type+" entity " + id);
    }
}