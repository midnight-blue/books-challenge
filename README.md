# Books Challenge

Gegeben ist eine List bestehend aus Elementen und Sammlungen.

```yaml
  - name: "The Art of Computer Programming"
    id: 0
    parentId: 3
    type: "item"

  - name: "Knuth, E"
    id: 3
    parentId: 5
    type: "collection"

  - name: "Non Fiction"
    id: 5
    type: "collection"

```

Konkret handelt es sich um Bücher in Kategorien.
Bücher können zu einer oder keiner Kategorie gehören, notiert durch das Feld `parentId`. Kategorien können wiederum
zu maximal einer Kategorie gehören, ebenfalls durch `parentId` notiert. Kategorien können beliebig tief verschachtelt
sein.

Deine Augabe ist es für jedes Element (d.h. für jedes Buch) den vollständigen, durch `/` separierten Pfad zu
konstruieren.
Im obigen Beispiel gibt es ein Buch in einer Kategorie in einer Überkategorie. Es ergibt sich also ein Pfad:

`/Non Fiction/Knuth, E/The Art of Computer Programming`

## Umgebung

Es existiert eine vorbereitete Klasse `BookOrganizer` mit einer Methode `organize`. Implementiere diese Methode
entsprechend
der obigen Vorgaben.

Es existiert ein JUnit Test `BookOrganizerTest`. Deine Lösung ist vollständig, wenn beide Testmethoden erfolgreich sind.

# Lost and Found

Gegeben ist eine List von verlorenen sowie eine Liste von gefundenen Objekten. Jedes Objekt hat drei Attribute:

- Ihren Fund- bzw. Verlustzeitpunkt
- Ihren Fund- bzw. Verlustort
- Ihren Fund- bzw. Verlustbeschreibung

Die Aufgabe besteht darin, jedes verlorene Objekt zu einem gefundenen Objekt zuzuweisen.