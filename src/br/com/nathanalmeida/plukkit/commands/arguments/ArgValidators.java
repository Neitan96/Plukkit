package br.com.nathanalmeida.plukkit.commands.arguments;

import org.bukkit.Bukkit;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 05/04/2016 14:31
 */
public final class ArgValidators{

    public static ArgumentValidator byteNumber(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    //noinspection ResultOfMethodCallIgnored
                    Byte.parseByte(argument);
                    return true;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator byteMin(final byte min){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return byteNumber().validArgument(argument) && Byte.parseByte(argument) >= min;
            }
        };
    }

    public static ArgumentValidator byteMax(final byte max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return byteNumber().validArgument(argument) && Byte.parseByte(argument) <= max;
            }
        };
    }

    public static ArgumentValidator byteRange(final byte min, final byte max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    byte aByte = Byte.parseByte(argument);
                    return aByte >= min && aByte <= max;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator shortNumber(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    //noinspection ResultOfMethodCallIgnored
                    Short.parseShort(argument);
                    return true;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator shortMin(final short min){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return shortNumber().validArgument(argument) && Short.parseShort(argument) >= min;
            }
        };
    }

    public static ArgumentValidator shortMax(final short max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return shortNumber().validArgument(argument) && Short.parseShort(argument) <= max;
            }
        };
    }

    public static ArgumentValidator shortRange(final short min, final short max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    short aShort = Short.parseShort(argument);
                    return aShort >= min && aShort <= max;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator intNumber(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    //noinspection ResultOfMethodCallIgnored
                    Integer.parseInt(argument);
                    return true;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator intMin(final int min){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return intNumber().validArgument(argument) && Integer.parseInt(argument) >= min;
            }
        };
    }

    public static ArgumentValidator intMax(final int max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return intNumber().validArgument(argument) && Integer.parseInt(argument) <= max;
            }
        };
    }

    public static ArgumentValidator intRange(final int min, final int max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    int aInt = Integer.parseInt(argument);
                    return aInt >= min && aInt <= max;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator longNumber(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    //noinspection ResultOfMethodCallIgnored
                    Long.parseLong(argument);
                    return true;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator longMin(final long min){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return longNumber().validArgument(argument) && Long.parseLong(argument) >= min;
            }
        };
    }

    public static ArgumentValidator longMax(final long max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return longNumber().validArgument(argument) && Long.parseLong(argument) <= max;
            }
        };
    }

    public static ArgumentValidator longRange(final long min, final long max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    long aLong = Long.parseLong(argument);
                    return aLong >= min && aLong <= max;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator floatNumber(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    //noinspection ResultOfMethodCallIgnored
                    Float.parseFloat(argument);
                    return true;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator floatMin(final float min){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return floatNumber().validArgument(argument) && Float.parseFloat(argument) >= min;
            }
        };
    }

    public static ArgumentValidator floatMax(final float max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return floatNumber().validArgument(argument) && Float.parseFloat(argument) <= max;
            }
        };
    }

    public static ArgumentValidator floatRange(final float min, final float max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    float aFloat = Float.parseFloat(argument);
                    return aFloat >= min && aFloat <= max;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator doubleNumber(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    //noinspection ResultOfMethodCallIgnored
                    Double.parseDouble(argument);
                    return true;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator doubleMin(final double min){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return floatNumber().validArgument(argument) && Double.parseDouble(argument) >= min;
            }
        };
    }

    public static ArgumentValidator doubleMax(final double max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return floatNumber().validArgument(argument) && Double.parseDouble(argument) <= max;
            }
        };
    }

    public static ArgumentValidator doubleRange(final double min, final double max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    double aDouble = Double.parseDouble(argument);
                    return aDouble >= min && aDouble <= max;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator dateSQL(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                try{
                    //noinspection ResultOfMethodCallIgnored
                    Date.valueOf(argument);
                    return true;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static ArgumentValidator dateBr(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                Pattern pattern = Pattern.compile("^([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})");
                Matcher matcher = pattern.matcher(argument);
                return matcher.matches()
                        && intMin(1900).validArgument(matcher.group(1))
                        && intRange(1, 12).validArgument(matcher.group(2))
                        && intRange(1, 31).validArgument(matcher.group(3));
            }
        };
    }

    public static ArgumentValidator hour(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                Pattern pattern = Pattern.compile("^([0-9]{1,2}):([0-9]{1,2})$");
                Matcher matcher = pattern.matcher(argument);
                return matcher.matches()
                        && intRange(0, 23).validArgument(matcher.group(1))
                        && intRange(0, 59).validArgument(matcher.group(2))
                        && (matcher.groupCount() <= 2 || intRange(0, 59).validArgument(matcher.group(3)));
            }
        };
    }

    public static ArgumentValidator player(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                //noinspection deprecation
                return Bukkit.getPlayer(argument) != null;
            }
        };
    }

    public static ArgumentValidator bool(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return argument.equalsIgnoreCase("yes")
                        || argument.equalsIgnoreCase("no")
                        || argument.equalsIgnoreCase("y")
                        || argument.equalsIgnoreCase("n")
                        || argument.equalsIgnoreCase("ok")
                        || argument.equalsIgnoreCase("all")
                        || argument.equalsIgnoreCase("none")
                        || argument.equalsIgnoreCase("sim")
                        || argument.equalsIgnoreCase("nao")
                        || argument.equalsIgnoreCase("não")
                        || argument.equalsIgnoreCase("true")
                        || argument.equalsIgnoreCase("false")
                        || argument.equalsIgnoreCase("1")
                        || argument.equalsIgnoreCase("0");
            }
        };
    }

    public static ArgumentValidator lengthMin(final int min){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return argument.length() >= min;
            }
        };
    }

    public static ArgumentValidator lengthMax(final int max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return argument.length() <= max;
            }
        };
    }

    public static ArgumentValidator lengthEqual(final int equal){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return argument.length() == equal;
            }
        };
    }

    public static ArgumentValidator lengthRange(final int min, final int max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return argument.length() >= min && argument.length() <= max;
            }
        };
    }

    public static ArgumentValidator listMinItens(final String regex, final int min){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return argument.split(Pattern.quote(regex)).length >= min;
            }
        };
    }

    public static ArgumentValidator listMaxItens(final String regex, final int max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return argument.split(Pattern.quote(regex)).length <= max;
            }
        };
    }

    public static ArgumentValidator listNumItens(final String regex, final int equals){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return argument.split(Pattern.quote(regex)).length == equals;
            }
        };
    }

    public static ArgumentValidator listRangeNumItens(final String regex, final int min, final int max){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                int length = argument.split(Pattern.quote(regex)).length;
                return length >= min && length <= max;
            }
        };
    }

    public static ArgumentValidator plugin(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return Bukkit.getPluginManager().getPlugin(argument) != null;
            }
        };
    }

    public static ArgumentValidator world(){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                return Bukkit.getWorld(argument) != null;
            }
        };
    }

    public static ArgumentValidator group(final ArgumentValidator... validators){
        return new ArgumentValidator(){
            @Override
            public boolean validArgument(String argument){
                for(ArgumentValidator validator : validators)
                    if(!validator.validArgument(argument)) return false;
                return true;
            }
        };
    }

}
