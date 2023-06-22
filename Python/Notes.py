import json
import datetime

# Constants for command line interface
ADD_NOTE = "add"
READ_LIST = "read"
EDIT_NOTE = "edit"
DELETE_NOTE = "delete"
DISPLAY_NOTE = "display"
EXIT_APP = "exit"

# File name for storing notes
NOTES_FILE = "notes.json"

# Function to load notes from file
def load_notes():
    try:
        with open(NOTES_FILE, "r") as f:
            notes = json.load(f)
    except FileNotFoundError:
        notes = []
    except Exception as e:
        print(f"Error loading notes: {e}")
        notes = []
    return notes

# Function to save notes to file
def save_notes(notes):
    try:
        with open(NOTES_FILE, "w") as f:
            json.dump(notes, f)
    except Exception as e:
        print(f"Error saving notes: {e}")

# Function to display all notes
def display_notes(notes):
    for note in notes:
        print("ID:", note["id"])
        print("Title:", note["title"])
        print("Body:", note["body"])
        print("Created:", note["created"])
        print("Last Updated:", note["last_updated"])
        print("------------------------")

# Function to display list of notes
def display_lists(notes):
    for note in notes:
        print("ID:", note["id"])
        print("Title:", note["title"])
        print("Created:", note["created"])
        print("------------------------")

# Function to display list of notes before main menu
def display_note_list():
    notes = load_notes()
    if len(notes) == 0:
        print("No notes found.")
    else:
        print("List of notes:")
        print("------------------------")
        display_lists(notes)

# Function to add a note
def add_note():
    title = input("Enter note title: ")
    body = input("Enter note body: ")
    created = datetime.datetime.now().strftime("%d-%m-%Y %H:%M:%S")
    last_updated = created
    notes = load_notes()
    if len(notes) > 0:
        last_id = notes[-1]["id"]
    else:
        last_id = 0
    new_note = {
        "id": last_id + 1,
        "title": title,
        "body": body,
        "created": created,
        "last_updated": last_updated
    }
    notes.append(new_note)
    save_notes(notes)
    print("Note successfully added!")

# Function to read notes, with optional date filtering
def read_notes():
    notes = load_notes()
    if len(notes) == 0:
        print("No notes found.")
        return
    date_filter = input("Enter date filter (DD-MM-YYYY) (optional): ")
    if date_filter == "":
        display_notes(notes)
    else:
        filtered_notes = [note for note in notes if note["created"].startswith(date_filter)]
        if len(filtered_notes) == 0:
            print("No notes found for specified date.")
        else:
            print("=============================")
            display_notes(filtered_notes)

# Function to display a selected note by ID
def display_selected_note():
    notes = load_notes()
    if len(notes) == 0:
        print("No notes found.")
        return
    try:
        note_id = int(input("Enter note ID: "))
        note = [n for n in notes if n["id"] == note_id]
        if len(note) == 0:
            print("Note not found")
            return
        note = note[0]
        print("=============================")
        print("ID:", note["id"])
        print("Title:", note["title"])
        print("Body:", note["body"])
        print("Created:", note["created"])
        print("Last Updated:", note["last_updated"])
        print("------------------------")
    except ValueError:
        print("Invalid ID format")
        return

# Main function to run the application
def main():
    display_note_list()
    while True:
        print("=============================")
        print("Notes App")
        print("Commands:")
        print("* add: Add a new note")
        print("* read: Read notes")
        print("* edit: Edit a note")
        print("* delete: Delete a note")
        print("* display: Display a note")
        print("* exit: Exit the application")
        command = input("\nEnter command: ")
        if command == ADD_NOTE:
            add_note()
        elif command == READ_LIST:
            read_notes()
        elif command == EDIT_NOTE:
            edit_note()
        elif command == DELETE_NOTE:
            delete_note()
        elif command == DISPLAY_NOTE:
            display_selected_note()
        elif command == EXIT_APP:
            break
        else:
            print("Invalid command. Please try again.")

if __name__ == "__main__":
    main()