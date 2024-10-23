file:///C:/Users/shubh/OneDrive/Documents/DSA/LinkedList/LL.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file:///C:/Users/shubh/OneDrive/Documents/DSA/LinkedList/LL.java
text:
```scala
package LinkedList;

public class LL {
  private Node head;
  private Node tail;
  
  
  private int size;

  public LL(){
    this.size=0;
  }
  public void insertFirst(int val){
       Node node =  new Node(val);
       node.next = head;
       head = node;
       if(tail==null){
        tail = head;
       }

       size+= 1;
  }
 public void insert(int val,int index){
  if(index==0){
    insertFirst(val);
  }
  if(index == size){
    insertLast(val);
  }
Node temp = head;
  for(int i = 0;i<=index-1;i++){
      temp = temp.next;
  }

  Node node = new Node(val,temp.next);
  

 }

  public void insertLast(int val){
            if(tail==null){
              insertFirst(val);
            }
    Node node = new Node(val);
    tail.next = node;
    tail = node;
  }
  public void display(){
    Node temp = head;
    while(temp!=null){
        System.out.println(temp.value+ "->");
        temp =  temp.next;
    }
    System.out.println("END");
  }
  private class Node{
    private int value;
    private Node next;

    public Node(int value){
        this.value = value;

    }
    public Node(int value,Node next){
        this.value = value;
        this.next = next;
    }
  }
}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:28)
	scala.meta.internal.pc.SimpleCollector.<init>(PcCollector.scala:373)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:117)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator