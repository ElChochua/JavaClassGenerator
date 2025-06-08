# Java Class Generator from a JSON File

## Example file input:

```json
[
  {
    "projectName":"Nombre de los cojones",
    "package":[
      {
        "packageName":"package de los putos cojones",
        "classes":[
          {
            "className":"clase1deloscojones",
            "isEntity": true,
            "fields":[
              {"name":"nombrecampo1deloscojones", "type":"int", "isIdField":true,"generationStrategy":"AUTO"},
              {"name":"nombrecampo2deloscojones", "type":"String"},
              {"name":"nombrecampo3deloscojones", "type":"String"},
              {"name":"nombrecampo4deloscojones", "type":"String"}
            ],
            "relationships":[
              {
                "type":"OneToMany",
                "mappedBy":"claseXdeloscojones",
                "cascade":["ALL"],
                "fetch":"LAZY"
              }
            ]
          },
          {
            "className":"clase2deloscojones",
            "isEntity": true,
            "fields":[
              {"name":"nombrecampo1deloscojones", "type":"float"},
              {"name":"nombrecampo2deloscojones", "type":"String"},
              {"name":"nombrecampo3deloscojones", "type":"String"},
              {"name":"nombrecampo4deloscojones", "type":"String"}
            ],
            "relationships":[
              {
                "type":"OneToMany",
                "mappedBy":"claseYdeloscojones",
                "cascade":["ALL"],
                "fetch":"LAZY"
              }
            ]
          }
        ]
      }
    ],
    "class":{
      "className":"claseSoladeloscojones",
      "isEntity": false,
      "fields": [
        { "name": "field5", "type": "boolean" },
        { "name": "field6", "type": "int" }
      ]
    }
  }
]
```

## Usage

Just replace the JSON path and run the program.

