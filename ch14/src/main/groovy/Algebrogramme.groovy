import org.gecode.*
import static org.gecode.Gecode.*
import static org.gecode.GecodeEnumConstants.*

class GroovySpace extends Space {
  public GroovySpace() {
    super()
  }
  public GroovySpace(Boolean share, GroovySpace space) {
    super(share, space)
  }
  def notEqual(IntVar v, val) {
    rel(this, v, IRT_NQ, val, ICL_BND)
  }
  def distinct(VarArray<IntVar> v) {
    distinct(this, v, ICL_BND)
  }
  def expressionsEqual(Expr e1, Expr e2) {
    post(this, e1, IRT_EQ, e2)
  }
  def branchOverVariables(VarArray<IntVar> v) {
    branch(this, v, BVAR_SIZE_MIN, BVAL_MIN)
  }
  def variableOverRange(v, r) {
      new IntVar(this, v, r.from, r.to)
  }
}

class Money extends GroovySpace {
  public VarArray<IntVar> letters

  public Money() {
    super()

    // We need 8 variables. Each one gets the name of it's
    // corresponding letter, and an initial domain of [0..9]
    letters = new VarArray<IntVar>(8)
    "SENDMORY".each{ letters.add(variableOverRange(it, 0..9)) }
    def s = letters[0]
    def e = letters[1]
    def n = letters[2]
    def d = letters[3]
    def m = letters[4]
    def o = letters[5]
    def r = letters[6]
    def y = letters[7]

    // set up constraints
    notEqual(s, 0)
    notEqual(m, 0)
    expressionsEqual(
        new Expr()
        .p(1000, s).p(100, e).p(10, n).p(d)
        .p(1000, m).p(100, o).p(10, r).p(e),
        new Expr()
        .p(10000, m).p(1000, o).p(100, n).p(10, e).p(y))
    distinct(letters)

    // start looking for solutions
    branchOverVariables(letters)
  }

  public Money(Boolean share, Money money) {
    super(share, money)
    letters = new VarArray<IntVar>(this, share, money.letters)
  }
}

def opt = new Options("SEND+MORE=MONEY")
opt.gui = true
opt.parse(args)
opt.doSearch(new Money())
