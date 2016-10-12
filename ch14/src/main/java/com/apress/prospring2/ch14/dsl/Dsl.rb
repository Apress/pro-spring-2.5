require 'java'

include_class 'java.math.BigDecimal'

class DiscountCalculator

    def calculate(i)
        d = BigDecimal.valueOf(0)
        i.lines.each {|l|
            if (l.sku == 'a') then
                d = d.add(BigDecimal.valueOf(1))
            end
        }
        if @@customerScoringService.score(i.customer) < 0.5 then
            d = BigDecimal.valueOf(0)
        end
        d
    end

    def setCustomerScoringService(css)
        @@customerScoringService = css
    end
end

DiscountCalculator.new