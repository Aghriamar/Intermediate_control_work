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