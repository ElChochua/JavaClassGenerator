# Java Class Generator from a JSON File

## Example file input:

```json
[
  {
    "type": "Package",
    "name": "MyPackage",
    "classes": [
      {
        "name": "ClassName1",
        "fields": [
          { "name": "field1", "type": "String" },
          { "name": "field2", "type": "int" }
        ]
      },
      {
        "name": "ClassName2",
        "fields": [
          { "name": "field1", "type": "boolean" },
          { "name": "field2", "type": "double" }
        ],
        "relations": [
          { "type": "one-to-many", "target": "ClassName1" }
        ]
      }
    ]
  },
  {
    "type": "Class",
    "name": "StandaloneClass",
    "fields": [
      { "name": "field1", "type": "float" },
      { "name": "field2", "type": "char" }
    ]
  }
]
```

## Usage

Just replace the JSON path and run the program.

