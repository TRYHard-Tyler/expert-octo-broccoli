# expert-octo-broccoli
A Multi-Value Dictionary application to allow users to view, add and remove value pairs.

### Implementation Details
- Java 13
- Development IDE: Eclipse for Mac

## Commands
_**All commands are entered on a single line, space delimited.**_ Ex. _**'ADD foo bar' would translate to the following; command=ADD, key='foo', value='bar'**_
- KEYS _(no parameters)_
  - Returns all _**unique**_ keys in the dictionary
  - Returns nothing if no keys exist
- MEMBERS _(key)_
  - Returns all _**distinct**_ values in the dictionary for a given _key_
  - Returns error if the request key does not exist in the dictionary
- ADD _(key value)_
  - Adds a key & value to the dictionary, returning a success message
  - If combination of key & value are not unique, returns error message
- REMOVE _(key value)_
  - Removes a key & value from the dictionary, returning a success message
  - If key does not exist in dictionary, an error message is returned
  - If key & value combination does not exist in dictionary, an error message is returned
- REMOVEALL _(key)_
  - Removes all key & value pairs for the key from the dictionary, returning a success message
  - If the key does not exist in dictionary, an error message is returned
- CLEAR _(no parameters)_
  - Removes all entries in the dictionary, returning a success message
- KEYEXISTS _(key)_
  - Returns true or false if the provided key exists in the dictionary
- VALUEEXISTS _(key value)_
  - Returns true or false if the provided value exists with the provided key in the dictionary
- ALLMEMBERS _(no parameters)_
  - Returns all _**(non-unique)**_ values in the dictionary
  - Returns nothing if no values exist
- ITEMS _(no parameters)_
  - Returns all _**unique**_ key & value pairs in the dictionary
  - Returns nothing if no entries exist

## Future Improvements - _Not Prioritized_
### Application
- Upgrade to latest Java release jdk
- Utilize POJO generator for objects
- Utilize property files for error messages

### UI
- Add commands
  - MODIFY: _Change value for a given key & value pair_
  - REMOVEVALUES: _Remove all values of a key, but leave key in dictionary **(Refactor)**_
- Provide user with listing of available commands
- Allow user an opportunity to exit the application

### Code
- Standardize layers
  - UI: _The UI layer should return information pertenant to a user based off the command given._
  - Service: _The service layer should return the command-specific data to be processed by the UI from the Data/Map layer._
  - Data/Map: _The data/map layer should return data from the dictionary for the service layer to process._
- Limit Data/Map layer to 3 methods: Read, Add, Remove **(Refactor)**
