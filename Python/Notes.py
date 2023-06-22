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