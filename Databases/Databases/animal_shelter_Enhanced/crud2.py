from pymongo import MongoClient, errors
from bson.objectid import ObjectId
from typing import Optional, Dict, Any, List


class AnimalShelter:
    """CRUD operations for the Animal collection in MongoDB."""

    def __init__(self, username: str, password: str, dbname: str, 
                 host: str = 'localhost', port: int = 27017) -> None:
        """
        Initialize MongoClient and connect to the specified database and collection.
        Raises ConnectionError on failure to connect.
        """
        try:
            connection_uri = f"mongodb://{username}:{password}@{host}:{port}/?authSource={dbname}"
            self.client = MongoClient(connection_uri, serverSelectionTimeoutMS=5000)
            # Force connection check
            self.client.admin.command('ping')
            self.database = self.client[dbname]
            self.collection = self.database['animals']
        except errors.ServerSelectionTimeoutError as err:
            raise ConnectionError(f"Failed to connect to MongoDB server: {err}")
        except errors.ConfigurationError as err:
            raise ConnectionError(f"MongoDB configuration error: {err}")
        except Exception as err:
            raise ConnectionError(f"Unexpected error during MongoDB connection: {err}")

    def create(self, data: Dict[str, Any]) -> ObjectId:
        """
        Insert a document into the collection.
        Returns the inserted document's ObjectId.
        Raises ValueError for invalid data.
        Raises RuntimeError on insertion failure.
        """
        if not data or not isinstance(data, dict):
            raise ValueError("Invalid or empty data provided for create.")

        try:
            result = self.collection.insert_one(data)
            if result.inserted_id is None:
                raise RuntimeError("Insert operation failed, no ID returned.")
            return result.inserted_id
        except errors.PyMongoError as err:
            raise RuntimeError(f"MongoDB insert operation failed: {err}")

    def read(self, query: Optional[Dict[str, Any]] = None) -> List[Dict[str, Any]]:
        """
        Query documents from the collection.
        Returns a list of documents, excluding the '_id' field.
        Raises ValueError for invalid query.
        Raises RuntimeError on query failure.
        """
        if query is not None and not isinstance(query, dict):
            raise ValueError("Query must be a dictionary or None.")

        try:
            cursor = self.collection.find(query or {}, {"_id": False})
            return list(cursor)
        except errors.PyMongoError as err:
            raise RuntimeError(f"MongoDB read operation failed: {err}")

    def update(self, query: Dict[str, Any], update_data: Dict[str, Any]) -> int:
        """
        Update documents matching the query with update_data.
        Returns the number of documents modified.
        Raises ValueError if query or update_data is invalid.
        Raises RuntimeError on update failure.
        """
        if not query or not update_data:
            raise ValueError("Both query and update_data are required for update.")
        if not isinstance(query, dict) or not isinstance(update_data, dict):
            raise ValueError("Query and update_data must be dictionaries.")

        try:
            result = self.collection.update_many(query, {"$set": update_data})
            return result.modified_count
        except errors.PyMongoError as err:
            raise RuntimeError(f"MongoDB update operation failed: {err}")

    def delete(self, query: Dict[str, Any]) -> int:
        """
        Delete documents matching the query.
        Returns the number of documents deleted.
        Raises ValueError for invalid query.
        Raises RuntimeError on delete failure.
        """
        if not query or not isinstance(query, dict):
            raise ValueError("Invalid or empty query provided for delete.")

        try:
            result = self.collection.delete_many(query)
            return result.deleted_count
        except errors.PyMongoError as err:
            raise RuntimeError(f"MongoDB delete operation failed: {err}")
