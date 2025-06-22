# Import the AnimalShelter class from crud2.py
from crud2 import AnimalShelter
from bson.objectid import ObjectId

# Setup: update these with your MongoDB credentials and database name
username = "aacuser"
password = "cs340"
dbname = "AAC"

# Instantiate the AnimalShelter
shelter = AnimalShelter(username, password, dbname)

# Test data for create
test_animal = {
    "name": "Testy",
    "type": "Dog",
    "age": 5,
    "breed": "TestBreed"
}

print("Running AnimalShelter CRUD tests...\n")

# --- Test CREATE ---
try:
    inserted_id = shelter.create(test_animal)
    print(f"[CREATE] Inserted document ID: {inserted_id}")
except Exception as e:
    print(f"[CREATE ERROR] {e}")

# --- Test READ ---
try:
    read_result = shelter.read({"name": "Testy"})
    print(f"[READ] Documents found: {len(read_result)}")
    for doc in read_result:
        print(doc)
except Exception as e:
    print(f"[READ ERROR] {e}")

# --- Test UPDATE ---
try:
    update_count = shelter.update({"name": "Testy"}, {"age": 6})
    print(f"[UPDATE] Documents modified: {update_count}")
except Exception as e:
    print(f"[UPDATE ERROR] {e}")

# --- Confirm update by reading again ---
try:
    updated_docs = shelter.read({"name": "Testy"})
    print("[READ AFTER UPDATE] Updated document(s):")
    for doc in updated_docs:
        print(doc)
except Exception as e:
    print(f"[READ AFTER UPDATE ERROR] {e}")

# --- Test DELETE ---
try:
    delete_count = shelter.delete({"name": "Testy"})
    print(f"[DELETE] Documents deleted: {delete_count}")
except Exception as e:
    print(f"[DELETE ERROR] {e}")

# --- Confirm deletion by reading again ---
try:
    post_delete_docs = shelter.read({"name": "Testy"})
    print(f"[POST DELETE] Documents remaining: {len(post_delete_docs)}")
except Exception as e:
    print(f"[READ AFTER DELETE ERROR] {e}")

# --- Test invalid create ---
try:
    shelter.create(None)
except ValueError as e:
    print(f"[EXPECTED CREATE ERROR] {e}")
except Exception as e:
    print(f"[UNEXPECTED CREATE ERROR] {e}")

# --- Test invalid read ---
try:
    shelter.read("not_a_dict")
except ValueError as ve:
    print(f"[EXPECTED READ ERROR] {ve}")
except Exception as e:
    print(f"[UNEXPECTED READ ERROR] {e}")

# --- Test invalid update ---
try:
    shelter.update({}, {})
except ValueError as ve:
    print(f"[EXPECTED UPDATE ERROR] {ve}")
except Exception as e:
    print(f"[UNEXPECTED UPDATE ERROR] {e}")

# --- Test invalid delete ---
try:
    shelter.delete("")
except ValueError as ve:
    print(f"[EXPECTED DELETE ERROR] {ve}")
except Exception as e:
    print(f"[UNEXPECTED DELETE ERROR] {e}")
