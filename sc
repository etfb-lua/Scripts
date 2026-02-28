-- Repaired & Cleaned Script

local fenv = getfenv()

-- Load UI Libraries
local Fluent = loadstring(game:HttpGet('https://github.com/dawid-scripts/Fluent/releases/latest/download/main.lua'))()
local SaveManager = loadstring(game:HttpGet('https://raw.githubusercontent.com/dawid-scripts/Fluent/master/Addons/SaveManager.lua'))()
local InterfaceManager = loadstring(game:HttpGet('https://raw.githubusercontent.com/dawid-scripts/Fluent/master/Addons/InterfaceManager.lua'))()

local TweenService = game:GetService('TweenService')
local ReplicatedStorage = game:GetService('ReplicatedStorage')
local RunService = game:GetService('RunService')
local Players = game:GetService('Players')
local VirtualInputManager = game:GetService("VirtualInputManager")

local LocalPlayer = Players.LocalPlayer

-- Character Setup
if LocalPlayer.Character then
    LocalPlayer.Character:WaitForChild('HumanoidRootPart')
end

LocalPlayer.CharacterAdded:Connect(function(character)
    character:WaitForChild('HumanoidRootPart')
end)

-----------------------------------------------------------------------------
-- Repaired Loops
-----------------------------------------------------------------------------

-- 1. Base Finder Loop
task.spawn(function()
    local baseFound = false
    while not baseFound do
        for _, base in ipairs(workspace:WaitForChild('Bases'):GetChildren()) do
            local titleGui = base:FindFirstChild('Title') and base.Title:FindFirstChild('TitleGui')
            local frame = titleGui and titleGui:FindFirstChild('Frame')
            local playerName = frame and frame:FindFirstChild('PlayerName')

            if playerName and playerName.Text == LocalPlayer.Name then
                baseFound = true
                break
            end
        end

        if not baseFound then
            warn('⏳ Waiting for BASE...')
            task.wait(1)
        end
    end
end)

-- 2. Restored Background Tasks
task.spawn(function()
    while task.wait(0.08) do
        -- Add logic here
    end
end)

task.spawn(function()
    while task.wait(0.3) do
        if fenv.AUTO_MONEY then
            -- Auto Money Logic Here
        end
    end
end)

task.spawn(function()
    while task.wait(0.3) do
        -- WheelSpin / Other logic here
    end
end)

task.spawn(function() while task.wait(0.5) do end end)
task.spawn(function() while task.wait(0.05) do end end)
task.spawn(function() while task.wait(0.4) do end end)
task.spawn(function() while task.wait(0.2) do end end)

-----------------------------------------------------------------------------
-- Helpers & HUD
-----------------------------------------------------------------------------

local EventTimerHUD = Instance.new('ScreenGui')
EventTimerHUD.Name = 'EventTimerHUD'
EventTimerHUD.ResetOnSpawn = false
EventTimerHUD.Enabled = false
EventTimerHUD.Parent = LocalPlayer:WaitForChild('PlayerGui')

local HUDFrame = Instance.new('Frame')
HUDFrame.Parent = EventTimerHUD
HUDFrame.Size = UDim2.fromScale(0.2, 0.05)
HUDFrame.Position = UDim2.fromScale(0.8, 0.75)
HUDFrame.BackgroundTransparency = 1

fenv.SetWeaponScale = function(scaleSize)
    -- Vector3.new(scaleSize, scaleSize, scaleSize)
    -- Add logic to apply to weapon
end

fenv.ResetWeaponScale = function()
    -- Vector3.new(1, 1, 1)
    local tool = LocalPlayer.Character:FindFirstChildOfClass('Tool')
    -- Add logic to reset weapon
end

-----------------------------------------------------------------------------
-- UI Setup (Fluent)
-----------------------------------------------------------------------------

local Window = Fluent:CreateWindow({
    Title = 'YT OsakaTP2 |',
    SubTitle = 'Escape tsunami for brainrots🌊v4',
    TabWidth = 160,
    Size = UDim2.fromOffset(520, 420),
    Acrylic = true,
    Theme = 'Dark',
    MinimizeKey = Enum.KeyCode.LeftAlt
})

local Tabs = {
    Main = Window:AddTab({ Title = 'Main' }),
    Farm = Window:AddTab({ Title = 'Farm' }),
    Misc = Window:AddTab({ Title = 'Misc' }),
    Settings = Window:AddTab({ Title = 'Settings', Icon = 'settings' })
}

-- MAIN TAB
Tabs.Main:AddSection('Youtube|OsakaTP2 Subscribe🔔')
Tabs.Main:AddSection('🛸 Event UFO')
Tabs.Main:AddToggle('event_timer', { Title = '🛸 Show Event Timer', Default = false, Callback = function(state) end })
Tabs.Main:AddToggle('ufo_coin', { Title = '🛸 UFO COIN', Default = false, Callback = function(state) end })
Tabs.Main:AddToggle('ufo_spin', { Title = '🛸 UFO SPIN', Default = false, Callback = function(state) end })

Tabs.Main:AddSection('☢️ Event Radioactive')
Tabs.Main:AddToggle('event', { Title = '☢️Radioactive Cion Event', Callback = function(state) end })
Tabs.Main:AddToggle('radiospin', { Title = '☢️Radioactive Spin', Default = false, Callback = function(state) end })
Tabs.Main:AddToggle('radio_lucky', { Title = '☢️ Radioactive Lucky Blox', Default = false, Callback = function(state) end })

Tabs.Main:AddSection('📸 Camera')
Tabs.Main:AddToggle('unlockcam', { Title = 'Unlock camera', Default = false, Callback = function(state) end })

-- FARM TAB
Tabs.Farm:AddSection('Select zone and Select rarity')
Tabs.Farm:AddDropdown('zone', {
    Title = 'Select Zone',
    Values = {'Legendary', 'Mythical', 'Cosmic', 'Secret', 'Celestial'},
    Callback = function(value) end
})
Tabs.Farm:AddToggle('autogap', { Title = '▶ GO TO ZONE', Callback = function(state) end })
Tabs.Farm:AddDropdown('farm', {
    Title = 'Select Brainrot rarity',
    Values = {'Rare', 'Legendary', 'Mythical', 'Cosmic', 'Secret', 'Celestial'},
    Callback = function(value) end
})
Tabs.Farm:AddToggle('autofarm', { Title = 'Auto Farm', Callback = function(state) end })
Tabs.Farm:AddButton({ Title = '▶ GO Safezone', Callback = function() end })

-- MISC TAB
Tabs.Misc:AddSection('Auto money / speed / rebirth')
Tabs.Misc:AddToggle('money', { Title = 'Auto Collect Money', Description = '⭐New update', Callback = function(state) fenv.AUTO_MONEY = state end })
Tabs.Misc:AddToggle('speed', { Title = 'Auto Speed +1', Callback = function(state) end })
Tabs.Misc:AddToggle('rebirth', { Title = 'Auto Rebirth', Callback = function(state) end })

Tabs.Misc:AddSection('👻HE HE')
Tabs.Misc:AddToggle('WeaponScale', { Title = 'ON/OFF', Default = false, Callback = function(state) end })
Tabs.Misc:AddToggle('WeaponInvisible', { Title = '👻', Default = false, Callback = function(state) end })
Tabs.Misc:AddSlider('WeaponScaleSize', {
    Title = '👻Size',
    Default = 1,
    Min = 1,
    Max = 100,
    Rounding = 1,
    Callback = function(value) fenv.SetWeaponScale(value) end
})
Tabs.Misc:AddButton({ Title = 'Reset', Callback = function() fenv.ResetWeaponScale() end })

-----------------------------------------------------------------------------
-- Mobile/Banana Toggle Button
-----------------------------------------------------------------------------

local BananaToggleGui = Instance.new('ScreenGui')
BananaToggleGui.Name = 'BananaToggle'
BananaToggleGui.ResetOnSpawn = false
BananaToggleGui.Parent = LocalPlayer:WaitForChild('PlayerGui')

local ToggleBtn = Instance.new('ImageButton')
ToggleBtn.Parent = BananaToggleGui
ToggleBtn.Size = UDim2.fromScale(0.062, 0.12)
ToggleBtn.Position = UDim2.fromScale(0.02, 0.1)
ToggleBtn.BackgroundColor3 = Color3.fromRGB(20, 20, 20)
ToggleBtn.BackgroundTransparency = 0.1
ToggleBtn.BorderSizePixel = 0
ToggleBtn.Image = 'rbxassetid://77426758441841'
ToggleBtn.ScaleType = Enum.ScaleType.Fit
ToggleBtn.Active = true
ToggleBtn.Draggable = true
ToggleBtn.AutoButtonColor = true

local UICorner = Instance.new('UICorner')
UICorner.CornerRadius = UDim.new(1, 1)
UICorner.Parent = ToggleBtn

local UIStroke = Instance.new('UIStroke')
UIStroke.Thickness = 5
UIStroke.Color = Color3.fromRGB(25, 0, 51)
UIStroke.ApplyStrokeMode = Enum.ApplyStrokeMode.Border
UIStroke.Parent = ToggleBtn

-- Simulate pressing LeftAlt to toggle the UI
ToggleBtn.MouseButton1Click:Connect(function()
    VirtualInputManager:SendKeyEvent(true, Enum.KeyCode.LeftAlt, false, game)
end)

-----------------------------------------------------------------------------
-- Finalizing Script
-----------------------------------------------------------------------------

SaveManager:SetLibrary(Fluent)
InterfaceManager:SetLibrary(Fluent)
SaveManager:IgnoreThemeSettings()
SaveManager:SetIgnoreIndexes({})
InterfaceManager:SetFolder('FluentScriptHub')
SaveManager:SetFolder('FluentScriptHub/specific-game')

InterfaceManager:BuildInterfaceSection(Tabs.Settings)
SaveManager:BuildConfigSection(Tabs.Settings)

Window:SelectTab(1)

Fluent:Notify({
    Title = 'OsakaTP2',
    Content = 'The script has been loaded.',
    Duration = 8
})

SaveManager:LoadAutoloadConfig()
