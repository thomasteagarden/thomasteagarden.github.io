from pymongo import MongoClient
from bson.objectid import ObjectId
from pprint import pprint


class AnimalShelter(object):
    """CRUD operations for Animal collection in MongoDB"""

    def __init__(self, username, password, dbname):
        # Initialize MongoClient
        self.client = MongoClient(
    'mongodb://%s:%s@localhost:27017/?authSource=%s' % (username, password, dbname))


        
        self.database = self.client[dbname]
        self.collection = self.database['animals']

    # Create method to implement the C in CRUD
    def create(self, data):
        if data is not None and isinstance(data, dict):
            result = self.collection.insert_one(data)
            return result.inserted_id
        else:
            raise Exception("[-] ERROR: Invalid or empty data provided for create.")

    # Read method to implement the R in CRUD
    def read(self, query):
        if query is not None and isinstance(query, dict):
            return self.collection.find(query, {"_id": False})
        else:
            raise Exception("[-] ERROR: Invalid or empty query provided for read.")

    # Update method to implement the U in CRUD
    def update(self, query, update_data):
        if query and update_data:
            result = self.collection.update_many(query, {"$set": update_data})
            return result.modified_count
        else:
            raise Exception("[-] ERROR: Both query and update_data are required for update.")

    # Delete method to implement the D in CRUD
    def delete(self, query):
        if query is not None and isinstance(query, dict):
            result = self.collection.delete_many(query)
            return result.deleted_count
        else:
            raise Exception("[-] ERROR: Invalid or empty query provided for delete.")
